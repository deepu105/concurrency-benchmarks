var app = WebApplication.CreateBuilder(args).Build();

app.MapGet("/", async () =>
{
    return Results.Text("Hello", "text/html");
});

// Sync version
// app.MapGet("/", () => 
// {
//     return Results.Text("Hello", "text/html");
// });

app.Run();