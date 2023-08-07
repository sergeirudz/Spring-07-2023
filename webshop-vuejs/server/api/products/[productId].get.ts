import { getErrorResponse, unWrap } from 'utils/fetchUtils';
import { sendJSON } from '../../helpers';

export default defineEventHandler(async (event) => {
  const config = useRuntimeConfig();
  const req = event.node.req;
  const res = event.node.res;
  const productId = event.context.params?.productId;

  try {
    const payload = await unWrap(
      await fetch(`https://dummyjson.com/products/${productId}`, {
        // `${config.BACKEND_URL}/api/products`
        headers: {},
        method: 'GET',
      })
    );
    console.log('payload', payload);
    sendJSON(payload.json, res);
  } catch (error: any) {
    return getErrorResponse(error);
  }
});
