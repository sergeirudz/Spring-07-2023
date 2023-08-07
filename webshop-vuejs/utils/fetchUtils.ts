export async function unWrap(response: Response) {
  const json = await response.json();
  const { ok, status, statusText } = response;
  return {
    json,
    ok,
    status,
    statusText,
  };
}

export function getErrorResponse(error: Error) {
  return {
    ok: false,
    status: 500,
    statusText: error.message,
    json: {},
  };
}
