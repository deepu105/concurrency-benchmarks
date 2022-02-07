var app = WebApplication.CreateBuilder(args).Build();

app.MapGet("/", async () => 
{
    return Results.Text(await File.ReadAllTextAsync("hello.html"), "text/html");
});

// Sync version
// app.MapGet("/", () => 
// {
//     return Results.Text(File.ReadAllText("hello.html"), "text/html");
// });

app.Run();