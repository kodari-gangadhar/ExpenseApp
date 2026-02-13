import React, { useState } from "react";
import UserList from "./components/UserList";
import CreateUser from "./components/CreateUser";
import CreateExpense from "./components/CreateExpense";

function App() {
  const [refresh, setRefresh] = useState(false);

  return (
    <div>
      <h1>ExpenseApp</h1>

      <CreateUser onUserCreated={() => setRefresh(!refresh)} />
      <hr />

      <UserList refresh={refresh} />
      <hr />

      <CreateExpense />
    </div>
  );
}

export default App;
