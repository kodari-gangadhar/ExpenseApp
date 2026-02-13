import React, { useState, useEffect } from "react";

function CreateExpense() {
  const [amount, setAmount] = useState("");
  const [description, setDescription] = useState("");
  const [userId, setUserId] = useState("");
  const [users, setUsers] = useState([]);

  // Load users for dropdown
  useEffect(() => {
    fetch("http://localhost:8081/users")
      .then(res => res.json())
      .then(data => setUsers(data))
      .catch(err => console.error("Error fetching users:", err));
  }, []);

 const handleSubmit = async (e) => {
  e.preventDefault();

  const expense = {
    amount: parseFloat(amount),
    description: description,
    user: {
      id: parseInt(userId)
    }
  };

  try {
    const response = await fetch("http://localhost:8081/expenses", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(expense)
    });

    if (!response.ok) {
      throw new Error("Failed to create expense");
    }

    alert("Expense created successfully ✅");

    setAmount("");
    setDescription("");
    setUserId("");

  } catch (error) {
    console.error("Error:", error);
    alert("Error creating expense ❌");
  }
};


  return (
    <div>
      <h2>Create Expense</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Amount"
          value={amount}
          onChange={e => setAmount(e.target.value)}
          required
        />
        <br /><br />

        <input
          type="text"
          placeholder="Description"
          value={description}
          onChange={e => setDescription(e.target.value)}
          required
        />
        <br /><br />

        <select
          value={userId}
          onChange={e => setUserId(e.target.value)}
          required
        >
          <option value="">Select User</option>
          {users.map(user => (
            <option key={user.id} value={user.id}>
              {user.name}
            </option>
          ))}
        </select>
        <br /><br />

        <button type="submit">Add Expense</button>
      </form>
    </div>
  );
}

export default CreateExpense;
