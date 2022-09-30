
import axios from "axios";
const ed_url = "http://localhost:8080/complaint/";

export class ComplaintService{
  getComplaintByRestOwner = (ownerId) => {
    return axios.get(ed_url + "getByRestOwner/" + ownerId);
  };

  addComplaint = (complaint) => {
    alert(complaint);
    return axios.post(ed_url + "add", complaint);
  };

  getComplaintsByUser = (userId) => {
    return axios.get(ed_url + "getByUser/" + userId);
  };

  resolveComplaint = (complaintId) => {
    return axios.put(ed_url + "resolve/"+ complaintId);
  };
}

export default new ComplaintService();
