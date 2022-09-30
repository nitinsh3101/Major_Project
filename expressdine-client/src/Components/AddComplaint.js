import React, { useEffect } from "react";
import { useState } from "react";
import ComplaintService from "./../Services/ComplaintService";
import { useParams } from "react-router-dom";
import "../css/addComplaint.css";
import swal from "sweetalert";

const AddComplaint = () => {
  const [comment, setComment] = useState("");
  const { orderId } = useParams();
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(orderId);
    let complaint = {
      comment: comment,
      lastReminder: "",
      reminderCount: 0,
      status: "unresolved",

      order: {
        id: orderId,
      },
    };

    ComplaintService.addComplaint(complaint)
      .then((res) => {
        swal({
          title: "Complaint added",
          icon: "success",
          timer: 2000,
          showCancelButton: false,
          showConfirmButton: false,
          buttons: false,
        });
        setTimeout(() => (window.location = "/restaurant"), 3000);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div class="loginbackground">
      <div className="inputback">
        <div class="formbackcom">
          <h1>Add Complaint</h1>
          <hr width="100%" size="10" color="black" align="center"></hr>
          <form className="align" onSubmit={handleSubmit}>
            <div>
              <textarea
                id="comment"
                name="comment"
                rows="8"
                cols="80"
                placeholder="Enter you complaint here"
                onChange={(e) => setComment(e.target.value)}
              ></textarea>
            </div>
            <div className="position">
              <button type="submit" className="btn btn-primary">
                Post Complaint
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddComplaint;
