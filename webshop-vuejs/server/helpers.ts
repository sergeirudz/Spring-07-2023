export function sendJSON(data: any, res: any) {
  res.setHeader('Content-Type', 'application/json');
  res.end(JSON.stringify(data));
}

export function rejectHitBadRequest(res: any) {
  res.statusCode = 400;
  res.end();
}
