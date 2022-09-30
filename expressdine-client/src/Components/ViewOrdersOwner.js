import React, { useEffect, useState } from "react";
import OrderService from "../Services/OrderService";
import swal from "sweetalert";

const ViewOrdersOwner = () => {
  const [orderList, setOrderList] = useState([]);
  const [ownerId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (ownerId == null) {
      window.location = "/";
    }

    OrderService.getOrders(ownerId).then((res) => {
      setOrderList(res.data);
    });
  }, []);

  const acceptOrder = (orderId) => {
    OrderService.acceptOrder(orderId).then((res) => {
      swal({
        title: "Order Accepted",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });
      setTimeout(() => ( window.location = "/viewOrdersOwner"), 2000);
    });
  };

  return (
    <div>
      <h2>Orders</h2>
      <hr />
      <table className="table">
        <thead>
          <tr>
            <th>User Id</th>
            <th>Name</th>
            <th>Food</th>
            <th>Quantity</th>
            <th>Amount</th>
            <th>Date</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {orderList.map((order) => (
            <tr>
              <td>{order.user?.id}</td>
              <td>{order.user?.name}</td>
              <td>{order.food?.name}</td>
              <td>{order.quantity}</td>
              <td>{order.amount}</td>
              <td>{order.orderedOn}</td>
              <td>
                {`${order.isAccepted}` === "no" ? (
                  <button
                    className="btn btn-outline-success"
                    onClick={() => acceptOrder(order.id)}
                  >
                    Accept
                  </button>
                ) : (
                  <div>Accepted</div>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ViewOrdersOwner;
