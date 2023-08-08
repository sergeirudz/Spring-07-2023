import { getErrorResponse } from '../../../utils/fetchUtils';
import { sendJSON } from '../../helpers';

export default defineEventHandler(async (event) => {
  const config = useRuntimeConfig();
  const req = event.node.req;
  const res = event.node.res;
  const body = await readBody(event);

  return {
    email: '1@1.com',
    accessToken: '111',
    refreshToken: '222',
  };

  try {
    const payload = new Promise((resolve, reject) => {
      resolve({
        email: '1@1.com',
        accessToken: '111',
        refreshToken: '222',
      });

      sendJSON(payload, res);
    });

    // const payload = await unWrap(
    //     await fetch(`${config.BACKEND_URL}/api/auth/register`, {
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         method: 'POST',
    //         body: JSON.stringify(req.body),
    //     })
    // );
    // sendJSON(payload.json, res);
  } catch (error: any) {
    return getErrorResponse(error);
  }
});
