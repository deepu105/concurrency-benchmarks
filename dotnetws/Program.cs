var app = WebApplication.CreateBuilder(args).Build();

app.MapGet("/", () => Results.Text("Hello", "text/html"));

app.Run();