import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    value: 0,
}

export const counterSlice = createSlice({
    name: 'counter',
    initialState,
    reducer: {
        increment(state, action) {
            state.value = state.value +1;
        },
        decrement: (state) => {
            state.value = state.value +1;
        },
        // incrementByAmount: (state, action) => {
        //   state.value += action.payload
        // },
    },
})

// Aciont creators are generated for each case reducer function
export const { increment, decrement, incrementByAmount } = counterSlice.actions

export default counterSlice.reducer
