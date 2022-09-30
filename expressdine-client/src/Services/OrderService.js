
import axios from "axios";
const ed_url = "http://localhost:8080/order";

export class OrderService{
  placeOrder = (userId) => {
    return axios.put(ed_url + "/placeOrder/" + userId);
  };

  getByUser = (userId) => {
    return axios.get(ed_url + "/getByUser/" + userId);
  };
  
  getOrders = (ownerId) => {
    return axios.get(ed_url + "/getOrders/"+ownerId);
  };

  getaccepted = () => {
    return axios.get(ed_url + "/getaccepted");
  };

  acceptOrder = (orderId) => {
    return axios.put(ed_url + "/acceptOrder/" + orderId);
  };
}

export default new OrderService();
