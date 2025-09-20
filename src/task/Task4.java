package task;

public class Task4 {

    //    You are given an array, prices, where prices[i] is the price of a given stock on the ith day.
//    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//    Example 1:
//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//
//    Example 2:
//    Input: prices = [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transactions are done and the max profit = 0.
//
//    Test input 1: [10,2,5,4,11,1]
//    Test input 2: [9,7,4,3,2,1]
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{10, 2, 5, 4, 11, 1}));
        System.out.println(maxProfit(new int[]{9, 7, 4, 3, 2, 1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int buy = prices[0];

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - buy);
            buy = Math.min(buy, price);
        }

        return maxProfit;
    }

//    Design API for Order: {"id": 1, "status": "in progress", "products": [{"sku": 100011}, {"sku": 100022}]})


//    For these endpoints, what would the path, http method, params, request/response body  look like?
//            • getAllOrders(); (add a filter by product)
//            • getOrderById(Long id);
//• createOrder(Order order);
//• updateOrder(Long id, Order order);
//• deleteOrderById(id);
//
//
//
//    Examples:
//    POST, /mypath, {"example": "body"}

    // POST /v1/orders  {"products": [{"sku": 100011}, {"sku": 100022}]}
    // PUT /v1/orders/{id}  {"products": [{"sku": 100011}, {"sku": 100022}]} 200
    // DELETE /v1/orders/{id}  200
    // GET /v1/orders?max=5&limit=10&product.sku=1000 {{"id": 1, "status": "in progress", "products": [{"sku": 100011}, {"sku": 100022}]}, "totalElements" : 5, "max" : 5, "limit": 7, "pageCount": 1}
    // GET /v1/orders/{id} {"id": 1, "status": "in progress", "products": [{"sku": 100011}, {"sku": 100022}]}
}
