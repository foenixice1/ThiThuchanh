package Services;

import Dao.ManageProduct;
import Models.Product;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> listSP = new ArrayList<>();

    public ProductService() {
        try {
            listSP= ManageProduct.showProduct();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Product product){
        try {
            ManageProduct.saveProduct(product);
            listSP= ManageProduct.showProduct();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(Product product,int index) {
        try {
            ManageProduct.editProduct(product);
            listSP = ManageProduct.showProduct();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int index) {
        try {
            ManageProduct.deleteProduct(listSP.get(index).getId());
            listSP = ManageProduct.showProduct();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Product> findByName(String name) throws Exception {
        return ManageProduct.findByName(name);
    }

}
