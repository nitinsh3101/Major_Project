import React, { useEffect, useState } from "react";
import ComplaintService from "../Services/ComplaintService";
import "../css/viewRestAdmin.css";

const ViewComplaintOwner = () => {
  const [complaintList, setComplaintList] = useState([]);
  const [ownerId] = useState(sessionStorage.getItem("userId"));

  const resolve = (complaintId) => {
    ComplaintService.resolveComplaint(complaintId).then(() => {
      window.location = "/viewComplaintOwner";
    });
  };

  useEffect(() => {
    if (ownerId == null) {
      window.location = "/";
    }

    ComplaintService.getComplaintByRestOwner(ownerId)
      .then((response) => {
        setComplaintList(response.data);
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
            <th scope="col">Complaint by</th>
            <th scope="col">Complaint</th>
            <th scope="col">Complaint Date</th>
            <th scope="col">Order Date</th>
            <th scope="col">Order Id</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {complaintList.map((complaint) => (
            <tr>
              <td>{complaint.order.user.name}</td>
              <td>{complaint.comment}</td>
              <td>{complaint.commentedOn}</td>
              <td>{complaint.order.orderedOn}</td>
              <td>{complaint.order.id}</td>

              <td>
                {`${complaint.status}` === "unresolved" ? (
                  <button
                    className="btn btn-outline-success"
                    onClick={() => resolve(complaint.id)}
                  >
                    Resolve
                  </button>
                ) : (
                  <div>Resolved</div>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ViewComplaintOwner;
