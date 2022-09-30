import React, { useEffect, useState } from 'react'
import FeedbackService from "./../Services/FeedbackService";

const ViewFeedback=()=> {
  const [feedbackList, setFeedbackList] = useState([]);
  const [userId, setUserId] = useState(sessionStorage.getItem("userId"));


  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
    FeedbackService.getAllFeedback()
      .then((response) => {
        setFeedbackList(response.data);
      })
      .catch((error) => {
        console.log({ errorMessage: error.message });
        console.error("There was an error!", error);
      });
  }, []);
  return (
    <div className="loginbackground">
    <table className="table table-light">
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Comment</th>
          <th scope="col">Feedback On</th>
          <th scope="col">Rating</th>
          
        </tr>
      </thead>
      <tbody>
        {feedbackList.map((feedback) => (
          <tr>
            <td>{feedback.name}</td>
            <td>{feedback.email}</td>
            <td>{feedback.comment}</td>
            <td>{feedback.feedback_on}</td>
            <td>{feedback.rating}</td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
  )
}

export default ViewFeedback