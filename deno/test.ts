// Deno uses modules referenced as URLs or file paths. Deno does not use NPM.
import { serve } from "https://deno.land/std@0.64.0/http/server.ts";

const s = serve({ port: 8000 });

// For easy navigation in dev
console.log("http://localhost:8000/");

// Wrapping in async func to avoid vscode complaints
// Not necessary as the support for Top Level Await (https://github.com/microsoft/TypeScript/issues/25988)
(async function () {
	for await (const req of s) {
		let bodyString = "Hello World";
		if (req.method == "GET") {
			bodyString += "\nmethod: GET";
		}
		const res = await fetch("http://example.com/");
		bodyString += `\nFetch example.com: ${res.statusText}`;

		req.respond({ body: bodyString });
	}
})();
