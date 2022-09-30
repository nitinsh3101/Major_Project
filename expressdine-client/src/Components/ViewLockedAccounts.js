import React, { useEffect, useState } from "react";
import LoginService from "../Services/LoginService";
import swal from "sweetalert";

function ViewLockedAccounts() {
  const [accountList, setAccountList] = useState([]);
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    LoginService.getLockedAccounts()
      .then((response) => {
        setAccountList(response.data);
      })
      .catch((error) => {
        console.error("There was an error!", error);
      });
  }, []);

  const unlock = (email) => {
    LoginService.unlock(email).then(() => {
      swal({
        title: "Account unlocked",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });
      setTimeout(() => (window.location = "/lockedAccounts"), 2000);
    });
  };

  return (
    <div>
      Locked Accounts
      <table className="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {accountList.map((account) => (
            <tr>
              <td>{account.user.name}</td>
              <td>{account.login.email}</td>
              <td>{account.user.phone}</td>
              <td>
                <button
                  className="btn btn-outline-success"
                  onClick={() => unlock(account.login.email)}
                >
                  Unlock
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ViewLockedAccounts;
