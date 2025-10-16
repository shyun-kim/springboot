import { validateFormCheck } from "../../utils/validate.js"
import { login, logout } from "./authSlice.js";

export const getLogin = (formData, param) => async(dispatch) => {
    if(validateFormCheck(param)) {
        /**
            SpringBoot - @RestController, @PostMapping("/member/login") -(formData가 JSON 파일로 생성됨)
            axios api
        */


        if("test" === formData.id && "1234" === formData.pwd) {
            dispatch(login({"userId" : formData.id}));
            return true;
        }
    }
    return false;
}

export const getLogout = () => async(dispatch) => {
    dispatch(logout());
    return true;
}