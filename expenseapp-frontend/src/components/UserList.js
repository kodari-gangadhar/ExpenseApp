import React, { useEffect, useState } from "react";

function UserList({ refresh }) {
  const [users, setUsers] = useState([]);

  const fetchUsers = () => {
    fetch("http://localhost:8081/users")
      .then((res) => res.json())
      .then((data) => setUsers(data))
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    fetchUsers();
  }, [refresh]);

  return (
    <div>
      <h2>Users</h2>
      <ul>
        {users.map((u) => (
          <li key={u.id}>
            {u.name} ({u.email})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserList;
