package Services;

import Dao.ManageCategory;
import Models.Category;

import java.util.ArrayList;

public class CategoryService {
    public ArrayList<Category> listCategory = new ArrayList<>();

    public CategoryService() {
        try {
            listCategory = ManageCategory.showCategory();
            for (Category loai: listCategory) {
                System.out.println(loai.getName());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
