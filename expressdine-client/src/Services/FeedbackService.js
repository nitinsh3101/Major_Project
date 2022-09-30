
import axios from "axios";
const ed_url = "http://localhost:8080/feedback";

export class FeedbackService {

  addFeedback = (feedback) => {
    return axios.post(ed_url + "/add", feedback);
  };
  getAllFeedback = () => {
    return axios.get(ed_url +"/getAll");
  };
}
export default new FeedbackService();
