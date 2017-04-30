package main.models.pojo;

/**
 * Created by admin on 24.04.2017.
 */
public class Order {
    private int id;
    private String orderName;
    private Users userName;
    private long time;
    private String status;
    private int resultPrice;
    private int user_id;

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Users getUserName() {
        return userName;
    }

    public void setUserName(Users userName) {
        this.userName = userName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResultPrice() {
        return resultPrice;
    }

    public void setResultPrice(int resultPrice) {
        this.resultPrice = resultPrice;
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", userName=" + userName +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", resultPrice=" + resultPrice +
                '}';
    }
}
