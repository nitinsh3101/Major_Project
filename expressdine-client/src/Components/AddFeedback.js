import React from "react";
import { useState } from "react";
import FeedbackService from "./../Services/FeedbackService";
import "../css/addFeedback.css";
import swal from "sweetalert";

const AddFeedback = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [comment, setComment] = useState("");
  const [rating, setRating] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    let feedback = {
      name: name,
      email: email,
      comment: comment,
      rating: rating,
    };

    FeedbackService.addFeedback(feedback)
      .then((res) => {
        swal({
          title: "Thanks !",
          text: "Your feedback has been submited successfully .",
          icon: "success",
          timer: 2000,
          showCancelButton: false,
          showConfirmButton: false,
          buttons: false,
        });

        setTimeout(() => (window.location = "/"), 2000);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <div className="loginbackground">
      <div className="inputback">
        <div class="formbackg">
          <h1>Add Feedback</h1>
          <hr width="100%" size="10" color="black" align="center"></hr>
          <form onSubmit={handleSubmit}>
            <div className="inputstyle">
              <input
                type="text"
                className="form-control"
                id="name"
                value={name}
                placeholder="Your Name"
                onChange={(e) => setName(e.target.value)}
              />
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className="form-control"
                id="price"
                value={email}
                placeholder="Your Email"
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div className="inputstyle">
              <textarea
                name="comment"
                rows="6"
                cols="30"
                value={comment}
                onChange={(e) => setComment(e.target.value)}
                placeholder="Feedback"
              ></textarea>
            </div>
            <div>
              <input
                type="number"
                name="rating"
                placeholder="Rate the website"
                value={rating}
                onChange={(e) => setRating(e.target.value)}
              />
            </div>
            <div className="inputstyle">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddFeedback;
