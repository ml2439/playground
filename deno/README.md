# Deno

[deno.land](https://deno.land/)

> A secure runtime for JavaScript and TypeScript.

## Secure by default

> Unless specifically allowed, scripts can't access files, the environment, or the network.

### Example

If run the following command in this directory
```
➜  deno run test.ts
```

An error would occur
```
Compile file:///Users/limengqiao/Git/Deno/test.ts
error: Uncaught PermissionDenied: network access to "0.0.0.0:8000", run again with the --allow-net flag
    at unwrapResponse ($deno$/ops/dispatch_json.ts:43:11)
    at Object.sendSync ($deno$/ops/dispatch_json.ts:72:10)
    at Object.listen ($deno$/ops/net.ts:51:10)
    at listen ($deno$/net.ts:152:22)
    at serve (https://deno.land/std@0.50.0/http/server.ts:261:20)
    at file:///Users/limengqiao/Git/Deno/test.ts:2:11
```

Additional flags are required to allow such access
```
➜  deno run --allow-net test.ts
```

Now navigate to `http://localhost:8000/` and should be able to see
```
Hello World
method: GET
Fetch example.com: OK
```

## Further Reading

- [Comparison to Node.js](https://deno.land/manual#comparison-to-nodejs)
- [Debugging in VSCode](https://deno.land/manual/tools/debugger#vscode)
