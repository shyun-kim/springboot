import React from 'react'
import { axiosData, groupByRows } from '../../utils/dataFetch.js';
import { createProduct, filterProduct } from './productSlice.js';

export const getProduct = (pid) => async(dispatch) => {
    // dispatch(filterProduct(pid));
    dispatch(filterProduct({"pid":pid}));
}

export const getProductList = (number) => async(dispatch) => {
    const jsonData = await axiosData("/data/products.json");
    const rows = groupByRows(jsonData, number);
    dispatch(createProduct({"productList": rows, "products":jsonData}));
}