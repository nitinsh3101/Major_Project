
import axios from "axios";

const ed_url = "http://localhost:8080/orderFeedback";

export class OrderFeedbackService{
  addOrderFeedback = (orderFeedback) => {
    return axios.post(ed_url + "/add", orderFeedback);
  };

  getOrderFeedbackByUser = (userId) => {
    return axios.get(ed_url + "/getByRestaurant/" + userId);
  };
}

export default new OrderFeedbackService();
