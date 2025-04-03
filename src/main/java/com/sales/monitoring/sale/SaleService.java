package com.sales.monitoring.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.monitoring.product.ProductModel;
import com.sales.monitoring.product.ProductService;

import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ProductService productService;

    public Optional<SaleModel> createSale(SaleModel sale) {

        // Pegando o id
        long productId = sale.getProduct().getId();

        // Se o id do produto for 0, significa que o produto não existe no banco de dados
        if (productId == 0) {
            return Optional.empty();
        } else {
            // Busca o produto no banco de dados
            ProductModel product = productService.findById(productId).orElse(null);

            
            
            if (product == null) {
                return Optional.empty();
            } else {
                // Define o preço da venda como a multiplicação da quantidade pelo valor do produto
                float saleValue = product.getProductValue() * sale.getQuantity();
            
                sale.setPrice(saleValue);
                sale.setProduct(product);
            }
        }

        SaleModel createdSale = saleRepository.save(sale);

        return Optional.ofNullable(createdSale);
        
    }
}
