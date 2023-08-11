import { getErrorResponse, unWrap } from "utils/fetchUtils";
import { sendJSON } from "../../helpers";
import { Register } from "../../models/register";

export default defineEventHandler(async (event) => {
    const config = useRuntimeConfig();
    const req = event.node.req;
    const res = event.node.res;
    const body: Register = await readBody(event);

    try {
        const response = await $fetch(`${config.BACKEND_URL}/auth/register`, {
            method: "POST",
            body,
        });

        return response;
    } catch (error) {
        console.log(error);
    }
});
