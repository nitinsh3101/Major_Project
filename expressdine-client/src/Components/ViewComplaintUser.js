import React, { useEffect, useState } from "react";
import ComplaintService from "../Services/ComplaintService";

const ViewComplaintUser = () => {
  const [complaintList, setComplaintList] = useState([]);

  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    ComplaintService.getComplaintsByUser(userId)
      .then((response) => {
        setComplaintList(response.data);
      })
      .catch((error) => {
        console.error("There was an error!", error);
      });
  }, []);

  return (
    <div class="loginbackground">
      <table class="table table-light">
        <thead>
          <tr>
            <th scope="col">Order Id</th>
            <th scope="col">Complaint</th>
            <th scope="col">Commented Date</th>
            <th scope="col">Status</th>
          </tr>
        </thead>
        <tbody>
          {complaintList.map((complaint) => (
            <tr>
              <td>{complaint.id}</td>
              <td>{complaint.comment}</td>

              <td>{complaint.commentedOn}</td>

              <td>{complaint.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ViewComplaintUser;
