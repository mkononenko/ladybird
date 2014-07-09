namespace java com.myco.ladybird.common.exchange.endpoint

typedef i32 Integer

typedef i64 Long

struct RegisterRequest {
}

struct RegisterResponse {
}

struct ConnectRequest {
}

struct ConnectResponse {
}

struct PingRequest {
}

struct PingResponse {
}

union ExchangeRequestPayload {
   1: RegisterRequest registerRequest
   2: ConnectRequest connectRequest
   3: PingRequest pingRequest
}

union ExchangeResponsePayload {
   1: RegisterResponse registerResponse
   2: ConnectResponse connectResponse
   3: PingResponse pingResponse
}

struct ExchangeRequest {
   1: ExchangeRequestPayload payload
}

struct ExchangeResponse {
   1: ExchangeResponsePayload payload
}