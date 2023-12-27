import React, { useState } from 'react'
import './AddProduct.css'

export default function AddProduct() {

    const [productData, setProductData] = useState(
        {
            title: '',
            description: '',
            brand: '',
            category: '',
            price: 0
        }
    )


    const handleChange = event => {
        setProductData({ ...productData, [event.target.name]: event.target.value });
        console.log(productData)
    }

    const showResponse = (productData) => {
        console.log(productData)
        alert(productData.title + " added!")

        // const productDataJSON = JSON.stringify(productData)
        // alert(productDataJSON)

    }

    const handleAdd = () => {

        fetch(`https://dummyjson.com/products/add`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                title: productData.title,
                description: productData.description,
                brand: productData.brand,
                category: productData.category,
                price: productData.price
            })
        })
            .then(response => response.json())
            .then(showResponse);

    };



    return (
        <div className='container product-add-form-group'>
            <h2 className='product-add-title'>Add a product</h2>
            <div className="mb-3 col-lg-5 col-md-6 col-12">
                <input className="form-control" onChange={handleChange} name='title' type="text" placeholder="Title" aria-label="default input example" />
            </div>
            <div className="mb-3 col-lg-5 col-md-6 col-12">
                <textarea className="form-control" onChange={handleChange} name='description' id="exampleFormControlTextarea1" placeholder='Description' rows="3"></textarea>
            </div>
            <div className="mb-3 col-lg-5 col-md-6 col-12">
                <input className="form-control" onChange={handleChange} name='brand' type="text" placeholder="Brand" aria-label="default input example" />
            </div>
            <div className="mb-3 col-lg-5 col-md-6 col-12">
                <input className="form-control" onChange={handleChange} name='category' type="text" placeholder="Category" aria-label="default input example" />
            </div>
            <div className="mb-3 col-lg-5 col-md-6 col-12">
                <input className="form-control" onChange={handleChange} name='price' type="number" placeholder="Price" aria-label="default input example" />
            </div>
            <div className="mb-3 col-lg-5 col-md-6 col-12">
                <button type="button" onClick={handleAdd} className="btn btn-success" style={{ width: "100px" }}>Add</button>
            </div>
        </div >
    )
}




