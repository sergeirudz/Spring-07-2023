import { getErrorResponse } from "../../../utils/fetchUtils";
import { sendJSON } from "../../helpers";
import { Login } from "../../models/login";

export default defineEventHandler(async (event) => {
    const config = useRuntimeConfig();
    const req = event.node.req;
    const res = event.node.res;
    const body: Login = await readBody(event);

    try {
        const response = await $fetch(`${config.BACKEND_URL}/auth/login`, {
            method: "POST",
            body,
        });
        console.log(res);
        return response;
    } catch (error: any) {
        return getErrorResponse(error);
    }
});
