
import axios from "axios";
const ed_url = "http://localhost:8080/food";

export class FoodService{
  getAllFood = (restId) => {
    return axios.get(ed_url + "/getAll/" + restId);
  };

  getAllFoodByOwner = (userId) => {
    return axios.get(ed_url + "/getAllByOwner/" + userId);
  }

  addFood = (food) => {
    return axios.post(ed_url + "/add", food);
  };

  getFoodById = (foodId) => {
    return axios.get(ed_url + "/getById/" + foodId);
  };

  deleteFood = (foodId) => {
    return axios.delete(ed_url+"/delete/" + foodId);
  };

  updateFood = (food, foodId) => {
    return axios.put(ed_url + "/edit/" + foodId, food);
  };

  addToFavFood = (FavouriteFood) => {
    return axios.post(ed_url + "/addFavouriteFood", FavouriteFood);
  };

  getAllFavouriteFood = (userId) => {
    return axios.get(ed_url + "/getFavouriteFood/" + userId);
  };

  removeItem = (foodId) => {
    return axios.delete(ed_url + "/deleteFavouriteFood/" + foodId);
  };
}

export default new FoodService();
