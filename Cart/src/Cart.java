/*
- 장바구니: 두개 이상의 상품을 담을 수 있어야합니다. (ex. 우유 2개, 화장지 3개)
    - items를 가지고 있습니다.

    다음과 같은 함수를 가지고 있어야 합니다.

    - showItems()
    - addProduct()
    - removeProduct()
 */

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int amount){
        // 현재 hashmap에 key가 있으면 개수를 더하고, 처음 들어온 product면 새로 추가를 해줌
//    if (items.containsKey(product)) {
//      items.put(product, items.get(product) + amount);
//    } else {
//      items.put(product, amount);
//    }

        items.merge(product, amount, Integer::sum);

    }

    public void removeProduct(Product product, int amount) {
        //있으면 갯수를 빼고, 없으면 stay..
        if (items.containsKey(product) && items.get(product) > 0) {
            items.put(product, items.get(product) - amount);
        }

    }

    public void showItems() {
        System.out.println("=== show items in cart ===");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue() + "개");
        }
    }

    public Map<String, Integer> showItemsStream() {
        return items.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
    }


}
