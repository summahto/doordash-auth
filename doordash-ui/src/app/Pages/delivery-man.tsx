import React from 'react';

const DeliveryMan = () => {
    // Mock data, replace with API call if necessary
    const orders = [
        { id: 1, items: "Pizza, Coke" },
        { id: 2, items: "Burger, Fries" },
        // Add more orders as needed
    ];

    const takeOrder = (orderId) => {
        console.log(`Taking order ${orderId}`);
        // Implement order taking logic here
    };

    const fulfillOrder = (orderId) => {
        console.log(`Fulfilling order ${orderId}`);
        // Implement order fulfillment logic here
    };

    return (
        <div>
            <h1>Delivery Man View</h1>
            {orders.map(order => (
                <div key={order.id}>
                    <p>Order {order.id}: {order.items}</p>
                    <button onClick={() => takeOrder(order.id)}>Take Order</button>
                    <button onClick={() => fulfillOrder(order.id)}>Order Fulfilled</button>
                </div>
            ))}
        </div>
    );
};

export default DeliveryMan;
