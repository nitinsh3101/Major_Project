import "../css/homepage.css";
import React, { useEffect } from "react";
import { Link } from "react-router-dom";

const Homepage = () => {

  useEffect(() => {
    sessionStorage.clear();
  },[])

  return (
    <div className="background">
      <div class="center">
        <div class="title">Can food possibly make you wild?</div>
        <div class="sub_title">Yes, when we serve you.</div>
        <div class="btns">
          <Link to="/login">
            <button>Login</button>
          </Link>
          <Link to="/addUser">
            <button>Sign Up</button>
          </Link>
          <Link to="/addFeedback">
            <button>Give Feedback</button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Homepage;
