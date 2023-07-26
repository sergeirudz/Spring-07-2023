package sergei.webshop.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sergei.webshop.entity.Product;
import sergei.webshop.repository.ProductRepository;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class ProductCache {

    @Autowired
    ProductRepository productRepository;

    LoadingCache<Long, Product> loadingCache = CacheBuilder
            .newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<>() {
                @Override
                public Product load(Long id){
                    return productRepository.findById(id).get();
                }
            });

    //replace all productRepository.findById(id).get() with loadingCache.get(id)
    // use productCache.getProduct(id) instead of productRepository.findById(id).get()


    public Product getProduct(Long id) throws ExecutionException {
        return loadingCache.get(id);
    }

    public Product refreshProduct(Long id, Product updatedProduct ) throws ExecutionException {
        loadingCache.put(id, updatedProduct);
        return loadingCache.get(id);
    }

    // in case product is out of stock.
    public void deleteFromCache(Long id){
        loadingCache.invalidate(id); // remove product from cache
        // .refresh - delete from cache and load again from db
    }
}
