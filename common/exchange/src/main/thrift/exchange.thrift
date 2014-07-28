namespace java com.myco.ladybird.common.exchange.endpoint

typedef i32 Integer

typedef i64 Long

struct AccountInfo {
    1: string email
    2: string phone
}

struct CreateAccountRequest {
    1: AccountInfo accountInfo
    2: binary password
}

struct CreateAccountResponse {
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
    1: CreateAccountRequest createAccountRequest
    2: ConnectRequest connectRequest
    3: PingRequest pingRequest
}

union ExchangeResponsePayload {
    1: CreateAccountResponse createAccountResponse
    2: ConnectResponse connectResponse
    3: PingResponse pingResponse
}

struct ExchangeRequest {
    1: ExchangeRequestPayload payload
}

struct ExchangeResponse {
    1: ExchangeResponsePayload payload
}