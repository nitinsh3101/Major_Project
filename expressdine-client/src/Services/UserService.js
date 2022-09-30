import axios from "axios";

const ed_url = "http://localhost:8080/user";

export class UserService{
  addUser = (user) => {
    return axios.post(ed_url + "/add", user);
  };

  UpdateUser = (user, userId) => {
    return axios.put(ed_url + "/edit/" + userId, user);
  };

  getUserById = (userId) => {
    return axios.get(ed_url + "/getById/" + userId);
  };
}

export default new UserService();
