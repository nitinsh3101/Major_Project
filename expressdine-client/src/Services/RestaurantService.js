
import axios from "axios";

const ed_url = "http://localhost:8080/restaurant";
export class RestaurantService{
  addRestaurant = (restaurant) => {
    return axios.post(ed_url + "/add", restaurant);
  };

  deleteRestaurant = (restId) => {
    return axios.delete(ed_url+"/delete/"+restId);
  }
  
  getRestaurantById = (restId) => {
    return axios.get(ed_url + "/getById/" + restId);
  };
  updateRestaurant = (restaurant, restId) => {
    return axios.put(ed_url + "/edit/" + restId, restaurant);
  };
  addToFavRestaurant = (FavouriteRestaurant) => {
    return axios.post(ed_url + "/addFavouriteRestaurant", FavouriteRestaurant);
  };

  getAllFavouriteRestaurant = (userId) => {
    return axios.get(ed_url + "/getFavouriteRestaurant/" + userId);
  };

  allRestaurant = () => {
    return axios.get(ed_url + "/getAll");
  };

  removeItem = (restaurantId) => {
    return axios.delete(ed_url + "/deleteFavouriteRestaurant/" + restaurantId);
  };
}

export default new RestaurantService();
