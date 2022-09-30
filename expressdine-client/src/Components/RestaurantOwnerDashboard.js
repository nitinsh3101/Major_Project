import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Flip from "react-reveal/Flip";
import "../css/admin.css";

const RestaurantOwnerDashboard = () => {
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
  }, []);

  return (
    <div className="background">
      <div className="container-fluid">
        <div className="row">
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 240, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/viewFoodRestOwner">
                    {" "}
                    <button className="btn btn-outline-dark">View Food</button>
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 240, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/viewComplaintOwner">
                    {" "}
                    <button className="btn btn-outline-dark">
                      View Complaint
                    </button>
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 240, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/addFood">
                    <button className="btn btn-outline-dark">Add Food</button>{" "}
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 240, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/viewOrdersOwner">
                    <button className="btn btn-outline-dark">
                      View Orders
                    </button>{" "}
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 240, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/viewOrderFeedback">
                    <button className="btn btn-outline-dark">
                      View Feedback
                    </button>{" "}
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RestaurantOwnerDashboard;
