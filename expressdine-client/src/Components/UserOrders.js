import React, { useEffect, useState } from "react";
import OrderService from "../Services/OrderService";

const UserOrders = () => {
  const [orderList, setOrderList] = useState([]);
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    OrderService.getByUser(userId).then((res) => {
      setOrderList(res.data);
      console.log(res.data);
    });
  }, []);

  return (
    <div>
      Order History
      <table className="table">
        <thead>
          <tr>
            <th>Food</th>
            <th>Quantity</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Is Accepted</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {orderList.map((order) => (
            <tr>
              <td>{order.food?.name}</td>
              <td>{order.quantity}</td>
              <td>{order.amount}</td>
              <td>{order.orderedOn}</td>
              <td>{order.isAccepted}</td>
              <td>
                <button
                  className="btn btn-outline-danger"
                  onClick={() =>
                    (window.location = `/addComplaint/${order.id}`)
                  }
                >
                  Complaint
                </button>
              </td>
              <td>
                <button
                  className="btn btn-outline-info"
                  onClick={() =>
                    (window.location = `/addOrderFeedback/${order.id}`)
                  }
                >
                  Feedback
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserOrders;
