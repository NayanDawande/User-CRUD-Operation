import { useEffect, useState } from 'react';
import UserForm from './components/UserForm';
import UserList from './components/UserList';

const App = () => {
  const [users, setUsers] = useState([]);

  // Fetch all users on component mount
  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await fetch('/getAll');
      const data = await response.json();
      setUsers(data);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  const addUser = async (user) => {
    try {
      const response = await fetch('/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(user),
      });
      const data = await response.json();
      setUsers([...users, data]);
    } catch (error) {
      console.error('Error adding user:', error);
    }
  };

  return (
    <div>
      <h1>User Management</h1>
      <UserForm onSubmit={addUser} />
      <UserList users={users} />
    </div>
  );
};

export default App;
