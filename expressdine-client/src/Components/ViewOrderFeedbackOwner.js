import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import OrderFeedbackService from "../Services/OrderFeedbackService";

const ViewOrderFeedbackOwner = () => {
  const [orderFeedbackList, setOrderFeedbackList] = useState([]);
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    OrderFeedbackService.getOrderFeedbackByUser(userId)
      .then((response) => {
        setOrderFeedbackList(response.data);
      })
      .catch((error) => {
        this.setState({ errorMessage: error.message });
        console.error("There was an error!", error);
      });
  }, []);

  return (
    <div className="loginbackground">
      <table className="table table-light">
        <thead>
          <tr>
            <th scope="col">Owner Id</th>
            <th scope="col">Feedback</th>
            <th scope="col">Feedback Date</th>
            <th scope="col">Rating</th>
          </tr>
        </thead>
        <tbody>
          {orderFeedbackList.map((orderFeedback) => (
            <tr>
              <td>{orderFeedback.id}</td>
              <td>{orderFeedback.comment}</td>
              <td>{orderFeedback.feedbackOn}</td>
              <td>{orderFeedback.rating}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ViewOrderFeedbackOwner;
