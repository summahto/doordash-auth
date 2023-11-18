import React, { useState } from 'react';

const Customer = () => {
    const [order, setOrder] = useState({ item1: '', quantity1: '', /* Add more items and quantities as needed */ });

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(order);
        // Implement order submission logic here
    };

    const handleChange = (event) => {
        setOrder({ ...order, [event.target.name]: event.target.value });
    };

    return (
        <div>
            <h1>Customer View</h1>
            <form onSubmit={handleSubmit}>
                {/* Generate multiple fields as needed */}
                <input type="text" name="item1" placeholder="Item Name" onChange={handleChange} />
                <input type="number" name="quantity1" placeholder="Quantity" onChange={handleChange} />
                {/* Add more fields for items and quantities */}
                <button type="submit">Submit Order</button>
            </form>
        </div>
    );
};

export default Customer;
