// import type { IncomingMessage, ServerResponse } from 'http';

import { getErrorResponse, unWrap } from '../../utils/fetchUtils';
import { sendJSON } from '../helpers';

export default defineEventHandler(async (event) => {
  const config = useRuntimeConfig();
  const req = event.node.req;
  const res = event.node.res;

  try {
    const payload = await unWrap(
      await fetch(`https://dummyjson.com/products`, {
        // `${config.BACKEND_URL}/api/products`
        headers: {},
        method: 'GET',
      })
    );
    sendJSON(payload.json.products, res);
  } catch (error: any) {
    return getErrorResponse(error);
  }
});
