
import axios from "axios";
const ed_url = "http://localhost:8080";

export class LoginService{
  login = (user) => {
    return axios.post(ed_url + "/login", user);
  };

  countLoginAttempt = (loginId, flag) => {
    return axios.post(ed_url + "/countLoginAttempt/" + loginId, flag);
  };

  addUser = (loginData) => {
    return axios.post(ed_url + "/addUserLogin", loginData);
  };

  getLockedAccounts = () => {
    return axios.get(ed_url+"/getLockedAccounts")
  }

  unlock = (email) => {
    return axios.put(ed_url+"/unlock/"+ email)
  }
}

export default new LoginService();
