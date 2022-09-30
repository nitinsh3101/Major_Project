import React, { useEffect } from "react";
import { useState } from "react";
import OrderFeedbackService from "./../Services/OrderFeedbackService";
import "../css/addFeedback.css";
import { useParams } from "react-router-dom";
import swal from "sweetalert";

const AddOrderFeedback = () => {
  const [comment, setComment] = useState("");
  const [rating, setRating] = useState("");
  const { orderId } = useParams();
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
  },[])

  const handleSubmit = (e) => {
    e.preventDefault();

    let orderFeedback = {
      comment: comment,
      rating: rating,
      order: {
        id: orderId,
      },
    };

    OrderFeedbackService.addOrderFeedback(orderFeedback)
      .then((res) => {
        swal({
          title: "Feedback added",
          icon: "success",
          timer: 2000,
          showCancelButton: false,
          showConfirmButton: false,
          buttons: false,
        });
        setTimeout(() => ( window.location = "/restaurant"), 3000);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div class="loginbackground">
     <div className="inputback">
        <div class="formbackfeed">
        <h1>Add Order Feedback</h1>
        <hr width="100%" 
        size="10" 
        color="black"
        align="center"></hr>
        <form onSubmit={handleSubmit}>
          <div>
            <textarea
              id="comment"
              name="comment"
              rows="8"
              cols="40"
              value={comment}
              onChange={(e) => setComment(e.target.value)}
              placeholder="Enter you feedback here.."
            ></textarea>

            <div className="inputstyle">
              Rate the food <input type="number" name="rating" 
              value={rating}
              onChange={(e) => setRating(e.target.value)}
              />
            </div>
          </div>
          <button type="submit" className="btn btn-primary">
            Post Order Feedback
          </button>
        </form>
      </div>
      </div>
    </div>
  );
};

export default AddOrderFeedback;