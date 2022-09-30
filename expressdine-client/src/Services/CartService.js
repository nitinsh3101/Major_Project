
import axios from "axios";
const ed_url = "http://localhost:8080/cart";

export class CartService{
  addToCart = (cart) => {
    return axios.post(ed_url + "/addItem", cart);
  };

  getCartItems = (userId) => {
    return axios.get(ed_url+ "/getItems/"+userId);
  }

  changeQuantity = (cart) => {
    return axios.put(ed_url + "/changeQuantity", cart);
  };

  removeItem = (cartId) => {
    return axios.delete(ed_url+"/delete/"+cartId);
  }

}

export default new CartService();
